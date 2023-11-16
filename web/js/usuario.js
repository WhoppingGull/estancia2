/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function llenarFormulario(fila){
    var codigo = $(fila).find(".codigo").text();
    var nombre = $(fila).find(".nombre").text();
    var apellido = $(fila).find(".apellido").text();
    var amaterno = $(fila).find(".amaterno").text();
    var activo = $(fila).find(".activo").text();
    var grupo = $(fila).find(".grupo").text();
    var sexo = $(fila).find(".sexo").text();
    var telefono = $(fila).find(".telefono").text();
    var edad = $(fila).find(".edad").text();
    var contrasena = $(fila).find(".contraseña").text();
    
    $("#txtCodigo").val(codigo);
    $("#txtNombre").val(nombre);
    $("#txtApellido").val(apellido);
    $("#txtAmaterno").val(amaterno);
   // $("#txtCodigo").val(activo);
    $("#txtGrupo option:contains("+grupo+")").attr('selected',true);
    $("#txtSexo").val(sexo);
    $("#txtTelefono").val(telefono);
    $("#txtEdad").val(edad);
    $("#txtContrasena").val(contrasena);
}

$(document).ready(function(){
    
    $("#exampleModal").on("hidden.bs.modal",function (){
       $('form')[0].reset(); 
    });
    
    $(document).on('click','.btnEditar',function(){
        llenarFormulario($(this).closest('tr')); 
    });
    
    $(document).on('click','.btnEliminar',function(){
        llenarFormulario($(this).closest('tr')); 
    });
    
    $(document).on('click','.btnImprimir',function(){
        llenarFormulario($(this).closest('tr')); 
    });
    
    
});












