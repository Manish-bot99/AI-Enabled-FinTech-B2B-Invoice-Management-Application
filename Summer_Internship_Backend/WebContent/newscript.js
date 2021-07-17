/////////////////////////Page loading
var pg = 1;


document.addEventListener("DOMContentLoaded", function() {
    loadData(0, 11); //initial 11
});

function loadData(start, limit) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/H2HBABBA2631/getInvoiceData.do?start=" + start + "&limit=" + limit, false);
    xhttp.send();
    console.log(xhttp.responseText);
    var data = xhttp.responseText;
    console.log(JSON.parse(data));
    data = JSON.parse(data);



    //Emptying the data of previous page when new page is loaded
    $('#neu').empty();



    //Inserting and display of the data on the grid on screen

    var list = '';

    // ITERATING THROUGH OBJECTS
    $.each(data, function(key, value) {

        //CONSTRUCTION OF ROWS HAVING
        // DATA FROM JSON OBJECT
        list += '<tr>';

        list += '<td><input type="checkbox" name="foo" id="' + value.FIELD1 + '" class="checkbox"></td>';

        list += '<td>' + value.name_customer + '</td>';

        list += '<td>' +
            value.cust_number + '</td>';

        list += '<td>' +
            value.invoice_id + '</td>';

        list += '<td>' +
            value.total_open_amount + '</td>';

        list += '<td>' +
            value.due_in_date + '</td>';

        list += '<td>' +
            value.clear_datepredicted + '</td>';

        list += '<td>' +
            value.DELAY_BUCKETDAYS + '</td>';

        list += '<td>Lorem Ipsum dolor..</td>'

        list += '</tr>';
    });

    //INSERTING ROWS INTO TABLE 
    $('#table').append(list);



}

//////////////////// Pagination


function prevfunction() {

    if (pg >= 2) {

        pg--;
    }
    loadData((pg - 1) * 11, 11);
}

function nextfunction() {

    pg++;
    loadData((pg - 1) * 11, 11);
}



////////////Select all function


function toggle(source) {
    checkboxes = document.getElementsByName('foo');
    for (var i = 0, n = checkboxes.length; i < n; i++) {
        checkboxes[i].checked = source.checked;
    }
}


//#####################################ADD MODAL

// Get the modal
var modal = document.getElementById("myModal");
var btn = document.getElementById("add");
var span = document.getElementsByClassName("add_close")[0];
var spanbut = document.getElementById("add_footer_cancel");
//var add = document.getElementById("footer_add");



btn.onclick = function() {
    modal.style.display = "block";
}

spanbut.onclick = function() {
        modal.style.display = "none";
    }
    // When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}


//############################EDIT MODAL

// Get the modal
var modal1 = document.getElementById("myModal1");
// Get the button that opens the modal1
var btn1 = document.getElementById("edit");
// Get the <span> element that closes the modal1
var span1 = document.getElementsByClassName("edit_close")[0];
// When the user clicks the button, open the modal1 
var spanbut1 = document.getElementById("edit_footer_cancel");
btn1.onclick = function() {
    modal1.style.display = "block";
}
spanbut1.onclick = function() {
        modal1.style.display = "none";
    }
    // When the user clicks on <span> (x), close the modal1
span1.onclick = function() {
    modal1.style.display = "none";
}

//#####################################DELETE MODAL

// Get the modal
var modal2 = document.getElementById("myModal2");
// Get the button that opens the modal2
var btn2 = document.getElementById("delete");
// Get the <span> element that closes the modal2
var span2 = document.getElementsByClassName("delete_close")[0];
// When the user clicks the button, open the modal2 
var spanbut2 = document.getElementById("delete_footer_cancel");
btn2.onclick = function() {
    modal2.style.display = "block";
}
spanbut2.onclick = function() {
        modal2.style.display = "none";
    }
    // When the user clicks on <span> (x), close the modal2
span2.onclick = function() {
    modal2.style.display = "none";
}

//##########################################For top close 


window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
    if (event.target == modal1) {
        modal1.style.display = "none";
    }
    if (event.target == modal2) {
        modal2.style.display = "none";
    }
}