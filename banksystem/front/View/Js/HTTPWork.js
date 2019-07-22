function loadPhones() {

    var xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8080/exchangeRates/date/" + document.getElementById("inputCurrentDate").value.toString(), true);
    xhr.onload = function (e) {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                fillTable(this.responseText)
                    } else {
                console.log(xhr.statusText);
            }
        }
    };
    xhr.onerror = function (e) {
        console.error(xhr.statusText);
    };

    xhr.send();
}

function fillTable(responseText) {
    var myArr = JSON.parse(responseText);
    for (var i = 0; i < myArr.length; i++){
        var table = document.getElementById("myTable");
        var row = table.insertRow(i+1);
        var currencyNameCell = row.insertCell(0);
        var currentRateCell = row.insertCell(1);
        var dateCell = row.insertCell(2);
        currencyNameCell.innerHTML = myArr[i].currencyTypeDto.name;
        currentRateCell.innerHTML = myArr[i].currentRate;
        dateCell.innerHTML = myArr[i].date;
    }
}


