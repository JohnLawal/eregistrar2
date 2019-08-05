$(function () {
    $('#tblStudents').DataTable({"ordering": false});
    //Date picker
    $('#enrollmentDate').datepicker({
        autoclose: true
    });
});

function submitdetails() {

    $.confirm({
        title: 'Proceed to add Patient?',
        content: "Please check your inputs one more time",
        buttons: {
            cancel: {
                text: 'Cancel',
                btnClass: 'btn btn-default'
            },
            confirm: {
                text: "Register",
                btnClass: 'btn btn-primary',
                action: function () {
                    addPatient();
                }
            }
        }
    });
}

function addPatient() {
    var outpatient = $("#outpatient").val();
    var fullname = $("#fullname").val();
    var email = $("#email").val();
    var phone = $("#phone").val();
    var date_of_birth = $("#datepicker").val();

    var fd = new FormData();

    fd.append("is_out_patient", outpatient);
    fd.append("fullname", fullname);
    fd.append("email", email);
    fd.append("phone", phone);
    fd.append("date_of_birth", date_of_birth);

    $.ajax({
        url: "registerpatient",
        data: fd,
        contentType: false,
        processData: false,
        type: 'POST',
        success: function (result) {
            var resultObj = JSON.parse(result);
            if (resultObj['status'] === "success") {
                $.dialog({
                    title: 'Successful!',
                    content: 'The patient has been added.'
                });
                location.href = "allpatients";
            } else {
                $.alert({
                    title: 'Error!',
                    content: resultObj['message']
                });
            }
        },
        error: function (xhr, status, error) {
            $.alert({
                title: 'Error!',
                content: 'Could not complete the process. ' + error
            });
        }
    });
}