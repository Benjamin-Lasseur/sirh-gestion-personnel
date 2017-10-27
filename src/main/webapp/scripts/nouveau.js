$( document ).ready(function() {
  $("#nom").on('focusout',function(e){
    if ($("#nom").val() == ''){
      console.log("Entrée dans if");
      $("#nom").addClass("is-invalid");
      $("#nom").val('');
    }else{
      $("#nom").removeClass("is-invalid");
      $("#nom").addClass("is-valid");
    }
  });
  $("#prenom").on('focusout',function(e){
    if ($("#prenom").val() == ''){
      $("#prenom").addClass("is-invalid");
      $("#prenom").val('');
    }else{
      $("#prenom").removeClass("is-invalid");
      $("#prenom").addClass("is-valid");
    }
  });
  $("#anniversaire").on('focusout',function(e){
    if ($("#anniversaire").val()==''){
      $("#anniversaire").addClass("is-invalid");
      $("#anniversaire").val('');
    }else{
      $("#anniversaire").removeClass("is-invalid");
      $("#anniversaire").addClass("is-valid");
    }
  });
  $("#adresse").on('focusout',function(e){
    if ($("#adresse").val() == ''){
      console.log("Entrée dans if");
      $("#adresse").addClass("is-invalid");
      $("#adresse").val('');
    }else{
      $("#adresse").removeClass("is-invalid");
      $("#adresse").addClass("is-valid");
    }
  });
  $("#numsecu").on('focusout',function(e){
    var t2=$("#numsecu").val().match(/\d{13}/);
    if (t2==null){
      $("#numsecu").addClass("is-invalid");
    }else{
      $("#numsecu").removeClass("is-invalid");
      $("#numsecu").addClass("is-valid");
    }
  });
  $("#bouttonCreer").on('click',function(){
    var t2=$("#numsecu").val().match(/\d{13}/);
    if($("#nom").val() == ''||$("#prenom").val() == ''||$("#anniversaire").val()==''||$("#adresse").val()==''||t2==null){
      if (t2==null){
        $("#numsecu").addClass("is-invalid");
      }else{
        $("#numsecu").removeClass("is-invalid");
        $("#numsecu").addClass("is-valid");
      }
      if ($("#adresse").val() == ''){
        console.log("Entrée dans if");
        $("#adresse").addClass("is-invalid");
        $("#adresse").val('');
      }else{
        $("#adresse").removeClass("is-invalid");
        $("#adresse").addClass("is-valid");
      }
      if ($("#anniversaire").val()==''){
        $("#anniversaire").addClass("is-invalid");
        $("#anniversaire").val('');
      }else{
        $("#anniversaire").removeClass("is-invalid");
        $("#anniversaire").addClass("is-valid");
      }
      if ($("#prenom").val() == ''){
        $("#prenom").addClass("is-invalid");
        $("#prenom").val('');
      }else{
        $("#prenom").removeClass("is-invalid");
        $("#prenom").addClass("is-valid");
      }
      if ($("#nom").val() == ''){
        console.log("Entrée dans if");
        $("#nom").addClass("is-invalid");
        $("#nom").val('');
      }else{
        $("#nom").removeClass("is-invalid");
        $("#nom").addClass("is-valid");
      }
    }else{
      $("#labelnom").html($("#nom").val());
      $("#labelprenom").html($("#prenom").val());
      $("#labelannivesaire").html($("#anniversaire").val());
      $("#labeladresse").html($("#adresse").val());
      $("#labelnumsecu").html($("#numsecu").val());
      $("#myModal").modal();
    }
  });
});
