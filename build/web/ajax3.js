$(document).ready(function(){
    $('#idCategorias').on('change', function(){///idCategorias/////////////////////////////////////////////////////////////////////
        $.ajax({
            type: 'GET',
            url: 'ArticulosController33',
            data: 'idCatController='+$('#idCategorias').val(),//idCategorias///////////////////////////////////////////////////////
            statusCode: {
                404: function() {//sltnomepais
                    console.log('Pagina no encontrada');
                },
                500: function(){
                    console.log('Erro no servidor');
                }
            },
            success: function(dados){
                pegadados = dados.split(":");
                limparselect();
                if(dados == '')
                    $('#idArticulos').append('<option>Categoria no tiene Articulos</option>');///////////////idArticulos
                else{
                    for(var i = 0; i < pegadados.length - 1; i++){
                        var codigoArticulo = pegadados[i].split("-")[0]; 
                        var nombreArticulo = pegadados[i].split("-")[1];
                        $('#idArticulos').append('<option value ="'+codigoArticulo+'">'+nombreArticulo+'</option>');/////////////////idArticulos

                    }
                }
            }
        }) 
        function limparselect(){
            $('#idArticulos option').remove();///////////////idArticulos
        }
    }); 
});