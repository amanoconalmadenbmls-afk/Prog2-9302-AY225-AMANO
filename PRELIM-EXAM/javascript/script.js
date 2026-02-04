// Programmer: CON AMANO - 25-2346-641

const csvData = 

let students = csvData.split("\n").slice(1).map(row => {
    let d = row.split(",");
    return {
        id: d[0],
        fname: d[1],
        lname: d[2],
        lw1: d[3],
        lw2: d[4],
        lw3: d[5],
        prelim: d[6],
        attend: d[7]
    };
});

function render() {
    const body = document.getElementById("tableBody");
    body.innerHTML = "";

    students.forEach((s, i) => {
        body.innerHTML += `
        <tr>
            <td>${s.id}</td>
            <td>${s.fname}</td>
            <td>${s.lname}</td>
            <td>${s.lw1}</td>
            <td>${s.lw2}</td>
            <td>${s.lw3}</td>
            <td>${s.prelim}</td>
            <td>${s.attend}</td>
            <td><button onclick="deleteStudent(${i})">Delete</button></td>
        </tr>`;
    });
}

function addStudent() {
    students.push({
        id: id.value,
        fname: fname.value,
        lname: lname.value,
        lw1: lw1.value,
        lw2: lw2.value,
        lw3: lw3.value,
        prelim: prelim.value,
        attend: attend.value
    });
    render();
}

function deleteStudent(i) {
    students.splice(i, 1);
    render();
}

render();