function Instructor_dietplan() {
    let anchor_diet = document.getElementById("ins_diet");
    let anchor_diet_i = document.getElementById("ins_diet_i");
    let diet_text = document.getElementById("Instructor_dietplan_text");
    console.log("mokada meee payments");
    anchor_diet.style.backgroundColor = "white";
    anchor_diet_i.style.color = "black";
    diet_text.style.color = "black";
  }



function add_diet_popup(){
    $('#add_diet_container').show();
}

function close_add_diet_Popup(){
    $('#add_diet_container').hide();
}

function Diet_plan_dashboard(){
    let anchor_workout = document.getElementById("phy_mem_diet_plan");
    let anchor_workout_i = document.getElementById("phy_mem_diet_plan_i");
    let workout_text = document.getElementById("physical_member_diet_plan_text");
    anchor_workout.style.backgroundColor = "white";
    anchor_workout_i.style.color = "black";
    workout_text.style.color = "black";
}

function requestDietPlanData(){
    physical_workoutplan_open_demo("diet_plan");
}

