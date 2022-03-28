function manager_setting_page(){
    let anchor_setting = document.getElementById("man_setting");
    let anchor_setting_i = document.getElementById("man_setting_i");
    let setting_text = document.getElementById("manager_setting_page_text");
    anchor_setting.style.backgroundColor = "white";
    anchor_setting_i.style.color = "black";
    setting_text.style.color = "black";
}


function email_regex_Validate(emailValue){
    let regexPattern = new RegExp(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/);    // regular expression pattern
    // let regexPattern = new RegExp(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/);
    return regexPattern.test(emailValue);
}

function edit_profile_change_role_submit(){

    let login_username = $('#edit_profile_container_detail_name11').val().trim();
    let login_password  = $('#edit_profile_container_detail_last_name11').val().trim();

    if(!email_regex_Validate(login_username)){
        //alert(email_regex_Validate(login_username));
        Swal.fire({
            icon: 'error',
            title: 'Email type is incorrect!',
            // text: 'Cannot be empty!',
            confirmButtonText:"Ok",
            confirmButtonColor: '#932828',
        })
        return;
    }

    // let form_inputs = {"user_name":login_name,"user_password":login_password};
    // form_inputs = JSON.stringify(form_inputs);

    if(login_username == '' || login_password == ''){
        // alert("Cant empty feilds");
        Swal.fire({
            icon: 'error',
            title: 'Login unsuccessfully!',
            text: 'Cannot be empty!',
            confirmButtonText:"Ok",
            confirmButtonColor: '#932828',
        })
        return;
    }else if(login_username.length < 6){
        // alert("Password length should be greater than 3 characters");
        Swal.fire({
            icon: 'error',
            title: 'Login unsuccessfully!',
            text: 'Password length should be greater than 3 characters!',
            confirmButtonText:"Ok",
            confirmButtonColor: '#932828',
        })

        return;
    }

    console.log(login_username);
    console.log(login_password);
    $.ajax({
        method: 'POST',
        url: "login",
        data:{login_username:login_username,login_password:login_password},
        //contentType : "text/plain",
        success:function (result){
            console.log(result);
            alert("Done");
            if(result.trim() == "1"){
                //instructor
                Swal.fire({
                    icon: 'success',
                    title: 'Login Success',
                    text: 'Instructor!',
                    confirmButtonText:"Ok",
                    confirmButtonColor: '#0E2C4B',
                })
                setTimeout(function() {
                    // window.location.href = 'http://localhost:8080/group39_fitbot_war_exploded/instructor';
                    window.location.href = 'http://localhost:8080/group39_fitbot_war_exploded/physicalMember';
                }, 1000);
            }else {
                Swal.fire({
                    icon: 'error',
                    title: 'Login unsuccessfully!',
                    text: 'User name and password does not match!',
                    confirmButtonText:"Ok",
                    confirmButtonColor: '#932828',
                })
            }

        },

        fail:function (error){
            alert(error);
        }

    })

}