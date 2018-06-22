// fetch
const studentsUrl = 'http://localhost:3000/students';
function init() {
    window.addEventListener(onload,loadStudents().then((data) => renderStudents(data)));
}
window.onload = init;

function renderStudents(students) {
    var studentList = document.getElementById('students');

    studentList.innerHTML = '<tr><th>Name</th><th>Grade</th></tr>\n';
    students.forEach(function (student) {
       studentList.innerHTML += `<tr><td>${student.name}</td><td>${student.grade}</td></tr>\n`;
    })
}

function loadStudents () {
    return fetch(studentsUrl).then(r => r.json());
}








// var Student = function (name, grade) {
//     this.name = name;
//     this.grade = grade;
// };
//
//
// var hardcodedStudents = [new Student('Vasiliy', '7'),
// new Student('Ivan', '8')];