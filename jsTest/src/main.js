const studentsUrl = 'http://localhost:3000/students';
function init() {
    window.addEventListener(onload,loadStudents().then((data) => renderStudents(data)));
    document.getElementById('student-form').addEventListener('click', addStudent);
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

    e.preventDefault();

    fetch(studentsUrl, {
        method:'POST',
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-type':'application/json'
        },
        body:JSON.stringify({name:studentName, grade:studentGrade})
    }).then((res) => loadStudents().then((data) => renderStudents(data)));

}








// var Student = function (name, grade) {
//     this.name = name;
//     this.grade = grade;
// };
//
//
// var hardcodedStudents = [new Student('Vasiliy', '7'),
// new Student('Ivan', '8')];