
document.addEventListener("DOMContentLoaded", function() {
    const deleteItemButtonsCollection = document.querySelectorAll('.deleteItem');
    deleteItemButtonList = Array.from(deleteItemButtonsCollection)
	deleteItemButtonList.forEach( function(deleteItemButton){
		deleteItemButton.addEventListener('click', function (){
		if (confirm('Are you sure you want to Delete this item?')){
			deleteItem();
		}})
});



function deleteItem() {
	const theButton = event.target
	const theDivWrappingTheButton = theButton.parentElement
	const id = theButton.dataset.id
	const xhr = new XMLHttpRequest()
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			theDivWrappingTheButton.parentElement.removeChild(theDivWrappingTheButton)
		}
	}
	xhr.open('DELETE', '/deleteTheItem/' + encodeURI(id),true)
	xhr.send()
}});