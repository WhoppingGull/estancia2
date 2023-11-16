/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

$(document).ready(function () {
    $("#exampleModal").on("hidden.bs.modal", function () {
        $('form')[0].reset();
    });

    $(document).on('click', '.btnEditar', function () {
        llenarFormulario($(this).closest('tr'));
    });

    $(document).on('click', '.btnEliminar', function () {
        llenarFormulario($(this).closest('tr'));
    });

    $(document).on('click', '.btnImprimir', function () {
        llenarFormulario($(this).closest('tr'));
    });

    function llenarFormulario(fila) {
        var idPerdida = $(fila).find(".codigo").text();
        var idProceso = $(fila).find(".idProceso").text();
        var idEstacion = $(fila).find(".idEstacion").text();
        var cantidad = $(fila).find(".cantidad").text();
        var estatus = $(fila).find(".estatus").text();
        var fechaPerdida = $(fila).find(".fechaPerdida").text();

        $("#txtCodigo").val(idPerdida);
        $("#txtIdProceso").val(idProceso);
        $("#txtIdEstacion").val(idEstacion);
        $("#txtCantidad").val(cantidad);
        $("#txtEstatus").val(estatus);
        $("#txtFechaPerdida").val(fechaPerdida);
    }

});

