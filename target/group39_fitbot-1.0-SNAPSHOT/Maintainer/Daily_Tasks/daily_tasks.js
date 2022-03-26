function maintain_Daily_Task() {
    let anchor_daily_tasks = document.getElementById("maintainer_Daily_Task");
    let anchor_daily_tasks_i = document.getElementById("maintainer_Daily_Task_i");
    let anchor_daily_tasks_text = document.getElementById("maintainer_Daily_Task_text");
    anchor_daily_tasks.style.backgroundColor = "white";
    anchor_daily_tasks_i.style.color = "black";
    anchor_daily_tasks_text.style.color = "black";
}

function getTodayTasks(){
    let date = new Date();
    let currentDate = date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+("0" + date.getDate()).slice(-2);
    // console.log(currentDate);

    $('#upcoming_task_maintainer').html(' ');

    //var today = new Date();
    //var currentTime = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    //console.log(currentTime);
    $.ajax({
        method:'POST',
        url:"maintainerDailyTasks",
        data:{currentDate:currentDate},
        // dataType: 'json',
        // contentType: "application/json",
    }).done(function (result){
        // console.log("in daily tasks0000000000");
        // console.log(result);
        let equipmentsList =result;
        let x = new Date();
        let currentDate =  x.getFullYear()+"-"+("0" + (x.getMonth() + 1)).slice(-2)+"-"+("0" + x.getDate()).slice(-2);
        let currentDate1 =  x.getFullYear()+"-"+("0" + (x.getMonth() + 1)).slice(-2)+"-"+("0" + (x.getDate() + 1)%30).slice(-2);
        // console.log(currentDate);
        // console.log("in current date");

        let count = 0;
        $.map(result,function(y){
            // console.log("Y= "+y.branch_name);
            $('#upcoming_task_maintainer').append(
                `<div class="right_side_bar_task_maintainer"><div>
                        <span>${y.branch_name}</span><br>
                        <span>${y.next_maintenance_date["year"]+"-"+("0" + (y.next_maintenance_date["month"])).slice(-2)+"-"+("0" + y.next_maintenance_date["day"]).slice(-2)} - ${y.category}</span>
                    </div>
                </div>`
            );
        });

        $.map(result,function(x){

            let equipment_has_modified = x.equipment_has_modified;
            let dateCompare= x.next_maintenance_date["year"]+"-"+("0" + (x.next_maintenance_date["month"])).slice(-2)+"-"+("0" + x.next_maintenance_date["day"]).slice(-2);
            // let dateCompare1= x.next_maintenance_date["year"]+"-"+("0" + (x.next_maintenance_date["month"])).slice(-2)+"-"+(("0" + x.next_maintenance_date["day"] + 1)%30).slice(-2);

            // let dateCompare = x.next_maintenance_date["year"]+"-"+x.next_maintenance_date["month"]+"-"+x.next_maintenance_date["day"];
            // console.log(dateCompare)
            if((currentDate == dateCompare) || (currentDate1 == dateCompare) && equipment_has_modified.trim().toString() == "0"){
                // alert("in x function");
                if(count < 2){
                    $.ajax({
                        method:'POST',
                        url:"maintainerList",
                    }).done(function (result1){
                        // console.log(result1);

                        let maintainerID = result1;
                        let equipmentID = x["equipment_id"];
                        //dateCompare
                        // console.log("maintainerID"+maintainerID);
                        // console.log("equipmentID"+equipmentID);

                        $.ajax({
                            method:'POST',
                            url:"maintainerTaskAssign",
                            data:{maintainerID:maintainerID,equipmentID:equipmentID,dateCompare:dateCompare}
                        }).done(function (result2){
                            // alert("come details" +result2)
                            // console.log(result2);
                            if(result2.trim() == "1"){
                                $('#daily_tasks_home_page').append(
                                    `<div class="tasks_home_page_maintainer">
                                        <div class="daily_tasks_home_page_branch_name">${x.branch_name} Branch</div>
                                        <div class="daily_tasks_home_page_type_and_id">${x.category} - ${x.equipment_id}</div>
                                        <div class="daily_tasks_home_page_description">${x.description}</div>
                                        <div class="daily_tasks_home_page_next_modification_date">${x.next_maintenance_date["year"]+"-"+("0" + (x.next_maintenance_date["month"])).slice(-2)+"-"+("0" + (x.next_maintenance_date["day"])).slice(-2)}</div>
                                        <div class="button_form1"> <input class="button_form" type="button" id="button_form" value="Complet" onclick='CompleteMaintain("${x.branch_name}","${x.category}" , "${x.equipment_id}","${x.description}")'></div>
                                    </div>`                                                                                                                    // onclick="CompleteMaintain(${x.branch_name},${x.category} , ${x.equipment_id},${x.description})"
                                );
                            }else {
                                console.log("Error of maintainer task assign")
                            }

                        }).fail(function (a,b,err) {
                            alert("Data loading error in daily tasks double ajax1");
                            console.log(a,b,err);
                        });

                        //let module_of_count=equipmentsList.length % maintainerList.length;
                        //let divition_of_count=equipmentsList.length / maintainerList.length;


                    }).fail(function (a,b,err) {
                        alert("Data loading error in daily tasks double ajax2");
                        console.log(a,b,err);
                    });
                }
            }

            count += 1;

        });

    }).fail(function (a,b,err) {
        alert("Data loading error in daily tasks");
        console.log(a,b,err);
    });

}

function DailyTasksBackgroundOn(){
    $('#maintainer_big_container_background').css('display','block');
}
function DailyTasksBackgroundOff(){
    $('#maintainer_big_container_background').css('display','none');
}




function CompleteMaintain(branch_name, category, equipment_id, description){
    // console.log(branch_name);
    // console.log(category);
    // console.log(equipment_id);
    // console.log(description);
    $('#maintain_form_view').show();
    // DailyTasksBackgroundOn();
    let date = new Date();
    let currentDate = date.getFullYear()+"-"+("0" + (date.getMonth() + 1)).slice(-2)+"-"+("0" + date.getDate()).slice(-2);
    // console.log(currentDate);

    var today = new Date();
    var currentTime = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    // console.log(currentTime);


    $('#maintainer_task_cancel').click(function(){
        // in requests.js file
        close_form_Popup();

    });

    $('#maintainer_task_submit').click(function(){
        // alert("in submit alert");


        let complet_dis = $('#maintain_add_note').val();
        let complet_img = $('#maintain_pic').val();

        $.ajax({
            method: 'POST',
            url: "maintainerDailyTaskForm",
            // contentType: 'application/json; charset=utf-8',
            data: {branch_name:branch_name, category: category, equipment_id: equipment_id,description:description,complet_dis:complet_dis,complet_img:complet_img,currentDate:currentDate,currentTime:currentTime},

            success: function (result) {
                // alert("done success");
                if (result.trim() == "1") {
                    // alert("done successsssssssssssssss");
                    reloadRequestData();
                    $('#maintainer_form input[type="text"],input[type="date"]  input[type="time"], textarea').val('');
                    $('#maintainer_form').hide();
                    Swal.fire({
                        icon: 'success',
                        title: 'Successfully Submit',
                        text: 'Done!',
                        confirmButtonText:"Ok",
                        confirmButtonColor: '#0E2C4B',
                    })
                    close_form_Popup();
                }
            },
            fail: function (error) {
                alert(error);
            }

        });
        e.preventDefault();

    });
}












