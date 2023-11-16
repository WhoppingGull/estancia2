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
        var idObservacion = $(fila).find(".idObservacion").text();
        var observacion = $(fila).find(".observacion").text();
        var fecha = $(fila).find(".fecha").text();
        var idSmdReporteMaquina = $(fila).find(".idSmdReporteMaquina").text();

        $("#txtCodigo").val(idObservacion);
        $("#txtObservacion").val(observacion);
        $("#txtFecha").val(fecha);
        $("#txtIdSmdReporteMaquina").val(idSmdReporteMaquina);
    }

});
