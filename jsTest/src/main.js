const studentsUrl = 'http://localhost:3000/students';
function init() {
    window.addEventListener(onload,loadStudents().then((data) => renderStudents(data)));
    document.getElementById('add').addEventListener('click', addStudent);
}
window.onload = init;

function renderStudents(students) {
    let studentList = document.getElementById('students');

    studentList.innerHTML = '<tr><th>Name</th><th>Grade</th></tr>\n';
    students.forEach(function (student) {
       studentList.innerHTML += `<tr><td>${student.name}</td><td>${student.grade}</td></tr>\n`;
    })
}

function loadStudents () {
    return fetch(studentsUrl).then(r => r.json());
}

function addStudent(e) {
    let studentName = document.getElementById('name').value;
    let studentGrade = document.getElementById('grade').value;
    console.log(e.elements);

    e.preventDefault();

    fetch(studentsUrl, {
        method:'POST',
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-type':'application/json'
        },
        body:JSON.stringify({name:studentName, grade:studentGrade})
    }).then(() => loadStudents().then((data) => renderStudents(data)));

}