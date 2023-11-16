//function llenarFormulario(fila) {
//    var idReporteMaquina = $(fila).find(".idReporteMaquina").text();
//    var idProceso = $(fila).find(".idProceso").text();
//    var batchOracle = $(fila).find(".batchOracle").text();
//    var batchLocal = $(fila).find(".batchLocal").text();
//    var pa = $(fila).find(".pa").text();
//    var total = $(fila).find(".total").text();
//    var handled = $(fila).find(".handled").text();
//    var good = $(fila).find(".good").text();
//    var bad = $(fila).find(".bad").text();
//    var remain = $(fila).find(".remain").text();
//    var remade = $(fila).find(".remade").text();
//    var lost = $(fila).find(".lost").text();
//    var removed = $(fila).find(".removed").text();
//    var purged = $(fila).find(".purged").text();
//    var recuperados = $(fila).find(".recuperados").text();
//    var creationDate = $(fila).find(".creationDate").text();
//
//    $("#txtCodigo").val(idReporteMaquina);
//    $("#txtIdProceso").val(idProceso);
//    $("#txtBatchOracle").val(batchOracle);
//    $("#txtBatchLocal").val(batchLocal);
//    $("#txtPa").val(pa);
//    $("#txtTotal").val(total);
//    $("#txtHandled").val(handled);
//    $("#txtGood").val(good);
//    $("#txtBad").val(bad);
//    $("#txtRemain").val(remain);
//    $("#txtRemade").val(remade);
//    $("#txtLost").val(lost);
//    $("#txtRemoved").val(removed);
//    $("#txtPurged").val(purged);
//    $("#txtRecuperados").val(recuperados);
//    $("#txtCreationDate").val(creationDate);
//}
//
//$(document).ready(function () {
//
//    $("#exampleModal").on("hidden.bs.modal", function () {
//        $('form')[0].reset();
//    });
//
//    $(document).on('click', '.btnEditar', function () {
//        llenarFormulario($(this).closest('tr'));
//    });
//
//    $(document).on('click', '.btnEliminar', function () {
//        llenarFormulario($(this).closest('tr'));
//    });
//});

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
        var idReporteMaquina = $(fila).find(".codigo").text();
        var idProceso = $(fila).find(".idProceso").text();
        var batchOracle = $(fila).find(".batchOracle").text();
        var batchLocal = $(fila).find(".batchLocal").text();
        var pa = $(fila).find(".pa").text();
        var total = $(fila).find(".total").text();
        var handled = $(fila).find(".handled").text();
        var good = $(fila).find(".good").text();
        var bad = $(fila).find(".bad").text();
        var remain = $(fila).find(".remain").text();
        var remade = $(fila).find(".remade").text();
        var lost = $(fila).find(".lost").text();
        var removed = $(fila).find(".removed").text();
        var purged = $(fila).find(".purged").text();
        var recuperados = $(fila).find(".recuperados").text();
        var creationDate = $(fila).find(".creationDate").text();

        $("#txtCodigo").val(idReporteMaquina);
        $("#txtIdProceso").val(idProceso);
        $("#txtBatchOracle").val(batchOracle);
        $("#txtBatchLocal").val(batchLocal);
        $("#txtPa").val(pa);
        $("#txtTotal").val(total);
        $("#txtHandled").val(handled);
        $("#txtGood").val(good);
        $("#txtBad").val(bad);
        $("#txtRemain").val(remain);
        $("#txtRemade").val(remade);
        $("#txtLost").val(lost);
        $("#txtRemoved").val(removed);
        $("#txtPurged").val(purged);
        $("#txtRecuperados").val(recuperados);
        $("#txtCreationDate").val(creationDate);
    }
});




