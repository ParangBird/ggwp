function handleSubmit(event) {
    event.preventDefault();
}
let tagButtons = document.querySelectorAll('tag-button');
tagButtons.forEach((button) => button.addEventListener('submit', handleSubmit));