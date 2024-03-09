var addStudentBtn = document.getElementById("addStudentBtn");
var addStudentModal = document.getElementById("addStudentModal");
var closeBtns = document.querySelectorAll(".close");
var deleteStudentModal = document.getElementById("deleteStudentModal");

closeBtns.forEach(function(btn) {
    btn.onclick = function() {
        addStudentModal.style.display = "none";
        deleteStudentModal.style.display = "none";
    }
});

addStudentBtn.onclick = function() {
    addStudentModal.style.display = "block";
}

closeBtn.onclick = function() {
    addStudentModal.style.display = "none";
}

window.onclick = function(event) {
    if (event.target == addStudentModal) {
        addStudentModal.style.display = "none";
    }
}

function openDeleteModal(id) {
    var deleteForm = document.getElementById("deleteStudentForm");
    deleteForm.querySelector("#deleteStudentId").value = id;
    deleteStudentModal.style.display = "block";
}

function openEditModal(id, firstName, lastName, email, age) {
    var editForm = document.getElementById("editStudentForm");
    // editForm.setAttribute("action", "/updateStudent?id=" + id);
    editForm.setAttribute("action", "/updateStudent");

    editForm.innerHTML = `
        <input type="hidden" name="id" value="${id}">
        <div>
            <label for="editFirstName">First Name:</label>
            <input type="text" id="editFirstName" name="first_name" value="${firstName}" required>
        </div>
        <div>
            <label for="editLastName">Last Name:</label>
            <input type="text" id="editLastName" name="last_name" value="${lastName}" required>
        </div>
        <div>
            <label for="editEmail">Email:</label>
            <input type="email" id="editEmail" name="email" value="${email}" required>
        </div>
        <div>
            <label for="editAge">Age:</label>
            <input type="number" id="editAge" name="age" value="${age}" required>
        </div>
        <button type="submit">Update</button>
    `;
    editStudentModal.style.display = "block";
}