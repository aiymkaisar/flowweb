// Показывает форму редактирования с заполнением данных
function showEditForm(button) {
    // Получение данных продукта из кнопки
    const productId = button.getAttribute("data-product-id");
    const name = button.getAttribute("data-name");
    const price = button.getAttribute("data-price");
    const discount = button.getAttribute("data-discount");
    const originalPrice = button.getAttribute("data-original-price");
    const imageUrl = button.getAttribute("data-image-url");

    // Заполнение полей формы редактирования
    const form = document.getElementById("editForm");
    if (form) {
        document.getElementById("editProductId").value = productId;
        document.getElementById("editName").value = name;
        document.getElementById("editPrice").value = price;
        document.getElementById("editDiscount").value = discount;
        document.getElementById("editOriginalPrice").value = originalPrice;
        document.getElementById("editImageUrl").value = imageUrl;

        // Обновляем действие формы с id продукта
        form.action = "/admin/update-product/" + productId;
    }

    // Показ формы редактирования
    document.getElementById("editFormContainer").style.display = "block";
}

// Скрывает форму редактирования
function hideEditForm() {
    document.getElementById("editFormContainer").style.display = "none";
}
