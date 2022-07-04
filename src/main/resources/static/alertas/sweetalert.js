function AlertaEliminar(elemento)
{
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
          confirmButton: 'btn btn-success',
          
          cancelButton: 'btn btn-danger'
        },
       
      })
      
      swalWithBootstrapButtons.fire({
        title: '¿Estas seguro?',
        text: "No podras revertir esta acción",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Eliminar',
        cancelButtonColor: '#d33',
        cancelButtonText: 'Cancelar',
        reverseButtons: true
      }).then((result) => {
        if (result.isConfirmed) {
          
   elemento.nextElementSibling.submit();
        } else if (
          /* Read more about handling dismissals below */
          result.dismiss === Swal.DismissReason.cancel
        ) {
          swalWithBootstrapButtons.fire(
            'Cancelado',
            'Su registro esta a salvo',
            'error'
          )
        }
    
    })
      
}




