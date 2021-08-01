function validate() {
   var name = document.getElementById("name-input");
   var surname = document.getElementById("surname-input");
   var phoneNumber = document.getElementById("phoneNumber-input");
   var place = document.getElementById("place-input");
   var district = document.getElementById("district-input");
   var street = document.getElementById("street-input");
   var numberHouse = document.getElementById("numberHouse-input");
   var numberLocal = document.getElementById("numberLocal-input");

  var flag = true;

  if(name.value == ""){
  name.style.background = "#e62249";
  flag = false;
  } else {
  name.style.background = "#ffffff"
  }

  if(surname.value == ""){
  surname.style.background = "#e62249";
  flag = false;
  } else {
  surname.style.background = "#ffffff"
  }

  if(phoneNumber.value == ""){
    phoneNumber.style.background = "#e62249";
    flag = false;
  } else {
    phoneNumber.style.background = "#ffffff"
  }


  if(place.value == ""){
    place.style.background = "#e62249";
    flag = false;
  } else {
    place.style.background = "#ffffff"
  }

  if(district.value == ""){
  district.style.background = "#e62249";
  flag = false;
  } else {
  district.style.background = "#ffffff"
  }

  if(street.value == ""){
  street.style.background = "#e62249";
  flag = false;
  } else {
  street.style.background = "#ffffff"
  }

  if(numberHouse.value == "" || isNaN(numberHouse.value)){
    numberHouse.style.background = "#e62249";
    flag = false;
  } else {
    numberHouse.style.background = "#ffffff"
  }

  if(numberLocal.value == "" || isNaN(numberLocal.value)){
    numberLocal.style.background = "#e62249";
    flag = false;
  } else {
    numberLocal.style.background = "#ffffff"
  }

  return flag;

}