document.addEventListener('DOMContentLoaded', function () {
    if (window.location.pathname === '/products') {
        const productsSection = document.getElementById('products');
        if (productsSection) {
            productsSection.scrollIntoView({ behavior: 'smooth' });
        }
    }
});
document.addEventListener('DOMContentLoaded', function () {
    if (window.location.pathname === '/contact-us') {
        const productsSection = document.getElementById('contact-us');
        if (productsSection) {
            productsSection.scrollIntoView({ behavior: 'smooth' });
        }
    }
});
