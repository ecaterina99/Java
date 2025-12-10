// State
let orders = [];
let loading = false;

// Elements
const investmentCcyInput = document.getElementById('investmentCcy');
const counterCcyInput = document.getElementById('counterCcy');
const buySelect = document.getElementById('buy');
const limitInput = document.getElementById('limit');
const validUntilInput = document.getElementById('validUntil');
const createOrderBtn = document.getElementById('createOrderBtn');
const refreshBtn = document.getElementById('refreshBtn');
const ordersTableBody = document.getElementById('ordersTableBody');
const errorContainer = document.getElementById('errorContainer');
const cancelOrderIdInput = document.getElementById('cancelOrderId');
const cancelOrderBtn = document.getElementById('cancelOrderBtn');
const cancelErrorContainer = document.getElementById('cancelErrorContainer');

// Auto-uppercase currency inputs
investmentCcyInput.addEventListener('input', (e) => {
    e.target.value = e.target.value.toUpperCase();
});

counterCcyInput.addEventListener('input', (e) => {
    e.target.value = e.target.value.toUpperCase();
});

// Show/hide error
function showError(message) {
    errorContainer.textContent = message;
    errorContainer.classList.remove('hidden');
}

function hideError() {
    errorContainer.classList.add('hidden');
}

function showCancelError(message) {
    cancelErrorContainer.textContent = message;
    cancelErrorContainer.classList.remove('hidden');
}

function hideCancelError() {
    cancelErrorContainer.classList.add('hidden');
}

// Load orders
async function loadOrders() {
    loading = true;
    refreshBtn.disabled = true;
    refreshBtn.textContent = 'Loading...';
    hideError();

    try {
        const response = await fetch('/orders', { method: 'GET' });

        if (!response.ok) {
            const err = await response.json();
            showError(err.message || 'Unknown error');
            ordersTableBody.innerHTML = `
                <tr>
                    <td colspan="6" class="text-center">
                        Failed to load orders
                    </td>
                </tr>
            `;
            return;
        }

        const data = await response.json();
        orders = data;
        renderOrders();
    } catch (e) {
        showError('Failed to load orders: ' + e.message);
        ordersTableBody.innerHTML = `
            <tr>
                <td colspan="6" class="text-center">
                    Failed to load orders
                </td>
            </tr>
        `;
    } finally {
        loading = false;
        refreshBtn.disabled = false;
        refreshBtn.textContent = 'Refresh';
    }
}

// Render orders
function renderOrders() {
    if (orders.length === 0) {
        ordersTableBody.innerHTML = `
            <tr>
                <td colspan="6" class="text-center">
                    No orders found
                </td>
            </tr>
        `;
        return;
    }

    ordersTableBody.innerHTML = orders.map(order => `
        <tr>
            <td class="order-id">${order.id}</td>
            <td>
                <span class="order-side ${order.buy ? 'buy' : 'sell'}">
                    ${order.buy ? 'BUY' : 'SELL'}
                </span>
            </td>
            <td class="order-pair">
                ${order.investmentCcy}/${order.counterCcy}
            </td>
            <td>${order.limit.toFixed(4)}</td>
            <td>${order.validUntil}</td>
            <td>${order.distance.toFixed(4)}</td>
        </tr>
    `).join('');
}

// Create order
async function handleCreateOrder() {
    const dto = {
        investmentCcy: investmentCcyInput.value,
        counterCcy: counterCcyInput.value,
        buy: buySelect.value === 'true',
        limit: parseFloat(limitInput.value),
        validUntil: validUntilInput.value
    };

    try {
        const response = await fetch('/orders', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(dto)
        });

        if (response.ok) {
            alert('Order created successfully!');
            investmentCcyInput.value = '';
            counterCcyInput.value = '';
            buySelect.value = 'true';
            limitInput.value = '';
            validUntilInput.value = '';
            loadOrders();
        } else {
            const err = await response.json();
            alert('Error: ' + err.message);
        }
    } catch (e) {
        alert('Error creating order: ' + e.message);
    }
}

// Cancel order
async function handleCancelOrder() {
    hideCancelError();

    if (!cancelOrderIdInput.value.trim()) {
        showCancelError('Please enter an Order ID!');
        return;
    }

    const dto = { id: cancelOrderIdInput.value };

    try {
        const response = await fetch('/orders/cancel', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(dto)
        });

        if (!response.ok) {
            const err = await response.json();
            showCancelError(err.message || 'Unknown error');
            return;
        }

        const result = await response.json();

        if (result === true) {
            alert('Order cancelled successfully!');
            cancelOrderIdInput.value = '';
            loadOrders();
        } else {
            alert('Order not cancelled.');
        }
    } catch (e) {
        showCancelError('Error cancelling order: ' + e.message);
    }
}

// Event listeners
createOrderBtn.addEventListener('click', handleCreateOrder);
refreshBtn.addEventListener('click', loadOrders);
cancelOrderBtn.addEventListener('click', handleCancelOrder);

// Initial load
loadOrders();