function modifyDiscipline() {

    var items = $(".custom-checkbox input[type=checkbox]:checked");

    if (items.length == 0) {
        alert("Пожалуйста выберите дисциплину");
        return;
    }
    if (items.length > 1) {
        alert("Нужно выбрать только одну дисциплину")
        return;
    }

    var id = items.eq(0).attr("value");

    $('#idModifyDisc').val(id);
    $('#formModifyDiscipline').submit();
}

function deleteDisciplines() {

    var items = $(".custom-checkbox input[type=checkbox]:checked");

    if (items.length == 0) {
        alert("Пожалуйста выберите хотя бы одну дисциплину");
        return;
    }

    var ids;

    for (var i = 0; i < items.length; i++) {
        if (ids == null) {
            ids = "'" + items.eq(i).attr("value");
        } else {
            ids = ids + "','" + items.eq(i).attr("value");
        }
        if (i == items.length - 1) {
            ids = ids + "'"
        }
    }

    $('#idsDeleteDisc').val(ids);
    $('#formDeleteDiscipline').submit();
}