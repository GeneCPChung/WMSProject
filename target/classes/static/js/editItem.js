
editItem
document.addEventListener("DOMContentLoaded", function() {
	const editItemButton = document.querySelector('#addItem');
	editItemButton.addEventListener('click',editItem)
});

function editItem(){
    const id = document.querySelector('#itemId').dataset.id
    const barcode = document.querySelector('#barcode').value
    const quantity = document.querySelector('#quantity').value
    const expirationDateString = document.querySelector('#expirationDateString').value
    const itemName = document.querySelector('#itemName').value
    const unit = document.querySelector('#unit').value
    const location = document.querySelector('#location').value
    const price = document.querySelector('#price').value
    const description = document.querySelector('#description').value
	const xhr = new XMLHttpRequest()
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr);
            console.log(id);
		}

	}
    xhr.open('PUT', '/editTheItem/' + id + '/' + barcode + '/' + quantity + '/' + expirationDateString + '/' + itemName + '/' + unit + '/' + location + '/' + price + '/' + description, true)
    xhr.send()
};