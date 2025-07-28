

document.getElementById('workerRegisterForm').onsubmit = function(e) {
    e.preventDefault();
    const worker = {
        fullname: e.target.fullname.value,
        email: e.target.email.value,
        phone: e.target.phone.value,
        location: e.target.location.value,
        skills: e.target.skills.value.split(',').map(s => s.trim()),
        experience: e.target.experience.value,
        bio: e.target.bio.value,
        // photo: handle photo upload if needed
    };
    const workers = JSON.parse(localStorage.getItem('workers')) || [];
    workers.push(worker);
    localStorage.setItem('workers', JSON.stringify(workers));
    alert('Profile posted!');
    e.target.reset();
};

document.getElementById('workerSearchForm').onsubmit = function(e) {
    e.preventDefault();
    const searchTerm = document.getElementById('searchTerm').value.toLowerCase();
    const skillFilter = document.getElementById('skillFilter').value;
    const locationFilter = document.getElementById('locationFilter').value;
    const workers = JSON.parse(localStorage.getItem('workers')) || [];
    const filtered = workers.filter(w => {
        const matchesSearch = w.fullname.toLowerCase().includes(searchTerm)
            || w.skills.join(',').toLowerCase().includes(searchTerm)
            || w.location.toLowerCase().includes(searchTerm);
        const matchesSkill = !skillFilter || w.skills.includes(skillFilter);
        const matchesLocation = !locationFilter || w.location === locationFilter;
        return matchesSearch && matchesSkill && matchesLocation;
    });
    displayWorkers(filtered);
};

// Optionally, display all workers on page load
window.onload = function() {
    const workers = JSON.parse(localStorage.getItem('workers')) || [];
    displayWorkers(workers);
};

function displayWorkers(workers) {
    const container = document.getElementById('workerResults');
    container.innerHTML = '';
    if (workers.length === 0) {
        container.innerHTML = '<p>No workers found.</p>';
        return;
    }
    workers.forEach(w => {
        const card = document.createElement('div');
        card.className = 'worker-card';
        card.innerHTML = `
            <h3>${w.fullname}</h3>
            <p><strong>Skills:</strong> ${w.skills.join(', ')}</p>
            <p><strong>Experience:</strong> ${w.experience} years</p>
            <p><strong>Location:</strong> ${w.location}</p>
            <p><strong>Contact:</strong> ${w.phone} | ${w.email}</p>
            <p>${w.bio}</p>
        `;
        container.appendChild(card);
    });
}
// ========== Page Initialization ==========

document.addEventListener('DOMContentLoaded', function() {
    // Find Workers page
    if (document.getElementById('results')) {
        renderWorkersList(getWorkers());
        const searchForm = document.querySelector('form');
        if (searchForm) {
            searchForm.addEventListener('submit', handleSearch);
        }
    }
    // For Workers page
    if (document.getElementById('name')) {
        const regForm = document.querySelector('form');
        if (regForm) {
            regForm.addEventListener('submit', handleWorkerRegistration);
        }
    }
});