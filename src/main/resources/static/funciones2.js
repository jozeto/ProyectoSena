function eliminarr(id,name) {
	swal({
		title: "¿ Estas seguro ?",
		text: "¡Una vez eliminado, no podrás recuperar a "+ name +"  !",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminarLogin/"+id,
					success: function(res){
						console.log(res);
					}
				})
				swal("¡Tu registro ha sido eliminado!", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/listarUsuarios"
					}
				});
			} else {
				swal("¡Tu registro está a salvo!", {
					icon: "info",
				});
			}
		});
}