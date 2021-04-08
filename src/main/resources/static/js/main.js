loadInforms();

function createInform() {
    var informDate = document.getElementById("date").value;
    var informName = document.getElementById("name").value;
    var informPrice = document.getElementById("price").value;

    if (informDate == "" || informName == "" || informPrice == "") return;
    if (informPrice < 0 || !Number.isInteger(Number(informPrice)) || informPrice > 2147483647) return;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8081/inform", true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({date: informDate, name: informName, price: informPrice}));

    setTimeout(loadInforms, 100);
    drawChart();

    document.getElementById("date").value = "";
    document.getElementById("name").value = "";
    document.getElementById("price").value = "";
}


function loadInforms() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var informs = JSON.parse(this.responseText);
            var html = '<tr>\n' +
                '        <th>Дата</th>\n' +
                '        <th>Название</th>\n' +
                '        <th>Стоимость</th>\n' +
                '        <th></th>\n' +
                '        <th></th>\n' +
                '    </tr>';
            for (var i = 0; i < informs.length; i++) {
                var inform = informs[i];
                html = html + '<tr><td><input type="date" id="val' + i + '" value=' + inform.date + ' /></td>' +
                    '        <td><input type="text" id="val' + (i + informs.length) + '" value=' + inform.name + ' /></td>' +
                    '        <td><input type="number" min=0 id="val' + (i + 2*informs.length) + '" value=' + inform.price + ' /></td>' +
                    '        <td><button onclick="updateInform(' + informs.length + ', ' + i + ', `' + inform.date + '`, `' + inform.name + '`)">Update</button></td>' +
                    '<td><button onclick="deleteInform(`' + inform.date + '`, `' + inform.name + '`)">Delete</button></td></tr>';
            }
            document.getElementById("informsList").innerHTML = html;
        }
    };
    xmlhttp.open("GET", "http://localhost:8081/inform", true);
    xmlhttp.send();
}

function updateInform(length, i, oldDate, oldName){

    var informDate = document.getElementById("val" + i).value;
    var informName = document.getElementById("val" + (i + length)).value;
    var informPrice = document.getElementById("val" + (i + 2*length)).value;

    if (informDate == "" || informName == "" || informPrice == "") return;
    if (informPrice < 0 || !Number.isInteger(Number(informPrice)) || informPrice > 2147483647) return;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("PUT", "http://localhost:8081/inform", true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({newDate: informDate, newName: informName, newPrice: informPrice, oldDate: oldDate, oldName: oldName}));

    setTimeout(loadInforms, 100);
    drawChart();
}


function deleteInform(informDate, informName){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("DELETE", "http://localhost:8081/inform", true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({date: informDate, name: informName}));

    setTimeout(loadInforms, 100);
    drawChart();
}

type="text/javascript"
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var Arr = JSON.parse(this.responseText);

            var arr = [];
            for(var i = 0; i < Arr.length; i++) {
                arr.push(Arr[i].date);
            }
            var arrSortDate = Array.from(new Set(arr));
            arrSortDate.sort();

            var arr1 = [];
            for(var j = 0; j < Arr.length; j++) {
                arr1.push(Arr[j].name);
            }
            var arrSortName = Array.from(new Set(arr1));
            arrSortName.sort();


            var arrChart = [];
            for(var i = 0; i < arrSortDate.length; i++) {
                arrChart[i] = [];
                arrChart[i].push(arrSortDate[i]);
                for(var j = 0; j < arrSortName.length; j++){
                    var val = null;
                    for (var k = 0; k < Arr.length; k++){
                        if (Arr[k].date == arrSortDate[i] && Arr[k].name == arrSortName[j]){
                            val = Arr[k].price;
                        }
                    }
                    arrChart[i].push(val);
                }
            }

            arrSortName.unshift('Year');
            arrChart.unshift(arrSortName);
            var data = google.visualization.arrayToDataTable(arrChart);

            var options = {
                title: 'График зависимости стоимости ценных бумаг от даты',
                hAxis: {title: 'Дата',  titleTextStyle: {color: '#333'}},
                vAxis: {title: 'Стоимость', minValue: 0},
                interpolateNulls: true
            };

            var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
            chart.draw(data, options);

        }
    };
    xmlhttp.open("GET", "http://localhost:8081/inform", true);
    xmlhttp.send();

}