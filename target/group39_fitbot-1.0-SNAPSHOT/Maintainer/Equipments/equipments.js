function maintain_equipments() {
  let anchor_equipments = document.getElementById("maintainer_equipments");
  let anchor_equipments_i = document.getElementById("maintainer_equipments_i");
  let anchor_equipments_text = document.getElementById("maintainer_equipments_text");
  // console.log("mokada meee dashboard");
  anchor_equipments.style.backgroundColor = "white";
  anchor_equipments_i.style.color = "black";
  anchor_equipments_text.style.color = "black";

}

function dataLoadEquipments(str){
  // alert("click search");
  // alert("change"+str);
  // console.log(str);
  // alert("click search");
  let Equipments_id = $('#search_equipment_by_ID').val();
  let Branch_selecter = str;
  // let List_order = $('#select_Filter_List_order').val();

  reloadEquipmentsData(Equipments_id,Branch_selecter);
}

function dataOrderEquipments(order){
  // alert("change"+order);
  // alert("click search");
  let Equipments_id = $('#search_equipment_by_ID').val();
  let Branch_selecter = $('#select_Filter_List').val();
  // let List_order = order;

  reloadEquipmentsData(Equipments_id,Branch_selecter);
}

function reloadEquipmentsData(Equipments_id,Branch_selecter){
  // alert(Branch_selecter);
  // console.log("+++++++++++");
  // console.log(List_order);
  // console.log(Branch_selecter);
  // console.log(Equipments_id);
  $('#maintain_equipments_tab_body').html(' ');
  $.ajax({
    method:'POST',
    url:"maintainerEqupimentsLoad",
    data:{Equipments_id:Equipments_id,Branch_selecter:Branch_selecter},

    // dataType: 'json',
    // contentType: "application/json",
  }).done(function (result){
    // console.log(result);
    $.map(result,function(x){
      let dateCompare= x.next_maintenance_date["year"]+"-"+("0" + (x.next_maintenance_date["month"] + 1)).slice(-2)+"-"+("0" + x.next_maintenance_date["day"]).slice(-2);
      let dateCompare1= x.last_modified_date["year"]+"-"+("0" + (x.last_modified_date["month"] + 1)).slice(-2)+"-"+("0" + x.last_modified_date["day"]).slice(-2);

      $('#maintain_equipments_tab_body').append(
          `<tr class="equipment_info">
          <td>${x.equipment_id}</td>
          <td>${x.category}</td>
          <td>${x.branch_name}</td>
          <td>${dateCompare1}</td>
          <td>${dateCompare}</td>
          </tr>`
      );
    });

  }).fail(function (a,b,err) {
    alert("Data loading error load equipments data");
    console.log(a,b,err);
  });
}


function loadBranchName(){
  // alert("call branch list");
  $('.branch_option_selecter_equipments').html(' ');
  $.ajax({
    method:'POST',
    url:"maintainerEquipmentPageBranchName",
    dataType: 'json',
    contentType: "application/json",
  }).done(function (result){
    console.log(result);
    $.map(result,function(x){
      $('.select_Filter_List').append(
          '<option class="branch_option_selecter_equipments" value='+x.branch_id +'>'+ x.branch_name +'</option>'
      );
    });

  }).fail(function (a,b,err) {
    alert("Data loading error");
    console.log(a,b,err);
  });
}

// function selectBranchSearch(){
//   alert("click search");
//   let Equipments_id = $('#search_equipment_by_ID').val();
//   let Branch_selecter = $('#select_Filter_List').val();
//   let List_order = $('#select_Filter_List_order').val();
//   alert(Branch_selecter);
//   reloadEquipmentsData(Equipments_id,Branch_selecter,List_order);
// }

function searchEquipmentsList(){
  // alert("click search");
  let Equipments_id = $('#search_equipment_by_ID').val();
  let Branch_selecter = $('#select_Filter_List').val();
  let List_order = $('#select_Filter_List_order').val();

  reloadEquipmentsData(Equipments_id,Branch_selecter,List_order);

}


function searchEquipmentsAny(){
  $('#search_equipment_by_ID').keyup(function(){
    // alert("yohan2");
    let value = $(this).val().toLowerCase();
    $('.equipment_info').filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
}