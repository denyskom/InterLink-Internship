// fetch
const studentsUrl = 'http://localhost:3000/students';
function init() {

}
// window.onload = init;

var Student = function (name, grade) {
    this.name = name;
    this.grade = grade;
};


var hardcodedStudents = [new Student('Vasiliy', '7'),
new Student('Ivan', '8')];


function renderStudents(students) {
    var studentList = document.getElementById('students');

    studentList.innerHTML = '<tr><th>Name</th><th>Grade</th></tr>\n';
    for (let i = 0; i < students.length ; i++) {
        studentList.innerHTML += `<tr><td>${students[i].name}</td><td>${students[i].grade}</td></tr>\n`;
    }
}

// function loadStudents () {
//     return fetch(studentsUrl).then(r => r.json());
// }