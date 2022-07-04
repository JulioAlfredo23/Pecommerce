
package com.comercio.Controller;

import com.comercio.Model.Producto;
import com.comercio.Model.Usuario;
import com.comercio.Service.ProductoService;
import com.comercio.Service.UploadFileService;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService PS;
    
    private final Logger loger=LoggerFactory.getLogger(ProductoController.class);
    
    @Autowired
    private UploadFileService Upload;
    
    @GetMapping("/")
    public String show(Model model){
        
        List<Producto> productos=PS.listarProductos();
        
        model.addAttribute("productos",productos);
        
        return "productos/show";
    }
    @GetMapping("/create")
    public String create(){
    
        return "productos/create";
        
    }
    
    @PostMapping("/save")
    public String save(Producto producto,@RequestParam("img") MultipartFile file) throws IOException{
        int a =2;
        long b=Long.parseLong(a+"");
        
        Usuario u= new Usuario(b, "", "", "", "", "", "", "");
        
        producto.setUsuario(u);
        
        //imagen
        if(producto.getId()==null){//cuando se crea un producto
            String nombreImagen=Upload.saveImage(file);
            
            producto.setImagen(nombreImagen);
        
        
        } else{
            if (file.isEmpty()){
            Producto p= new Producto();
            p= PS.get(producto.getId()).get();
            producto.setImagen(p.getImagen());
            
            }
            else{
            String nombreImagen=Upload.saveImage(file);
            
            producto.setImagen(nombreImagen);
            }
        }
        
        PS.save(producto);
        loger.info("Este es el objeto producto {}",producto);
    return "redirect:/productos/";
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
     
        Producto producto=new Producto();
        Optional<Producto> optionalProducto=PS.get(id);
             producto= optionalProducto.get();
             model.addAttribute("pro", producto);
             loger.info("producto buscado : {}",optionalProducto);
        
    return "productos/edit";
    }
    @PostMapping("/actualizar")
    public String actualizar(Producto p){
    
        PS.update(p);
        
        return "redirect:/productos/";
    }
    
    @PostMapping("/eliminar/{id}")
    public String elininar(@PathVariable Long id){
        
        PS.delete(id);
        
        
    return "redirect:/productos/";
    }
    
    
       
}
