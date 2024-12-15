# 🛒 Shopping List App

The **Shopping List App** is a feature-rich and user-friendly application designed to help you organize your shopping needs efficiently. Add, edit, and delete items seamlessly, with support for custom quantities and various measurement units.

---

## ✨ Features  

### ➕ Add Items  
- **Add Item Button**:  
  - On the homepage, click the **Add Item** button to open a dialog box.  
  - Provide the following details:  
    1. **Item Name**: Enter the name of the item you want to purchase.  
    2. **Quantity**:  
       - Choose from predefined options: `1`, `2`, `3`.  
       - Or select **Custom** to input a specific quantity.  
       - If invalid input (e.g., letters) is entered, the app defaults the value to `1`.  
    3. **Unit**: Select the measurement unit from:  
       - `qty` (generic quantity), `kilogram`, `gram`, `liter`, or `millilitre`.  
- **Buttons in the Dialog Box**:  
  - **Add**: Saves the entered details and displays the item on the homepage.  
  - **Cancel**: Clears all inputs and returns to the homepage without saving changes.  

---

### 📜 View Items  
- After adding, items appear as a list on the homepage, showing:  
  - **Item Name**  
  - **Quantity with Unit**  
  - Two action buttons: **Edit** and **Delete**.  

---

### 🖍️ Edit Items  
- Each item has an **Edit** button. Clicking it allows you to modify the item's details **directly on the homepage**.  
- The displayed fields (item name, quantity, and unit) convert into editable inputs.  
- Once the edits are complete, click **Save** to update the changes.  
- The updated details are saved, and the list reflects the changes immediately.  

---

### 🗑️ Delete Items  
- Each item also has a **Delete** button.  
- Clicking **Delete** removes the selected item from the list.  

---

### 🔢 Unlimited Items  
- There are no restrictions on the number of items you can add. Manage your entire shopping list with ease.  

---

## 🛠️ Technologies Used  

- **Frontend**: Jetpack Compose (Kotlin)  
- **Storage**: State management used. (no backend required)
- **Platform**: Android  

---

## 🛡️ Input Validation  

The app ensures robust input validation to improve user experience:  
- Custom quantities must be valid numeric values; otherwise, they default to `1`.  
- Unit selection defaults to `qty` if left unselected.  

---

## 🚀 How to Use  

1. **Add Items**:  
   - Click **Add Item** and fill in the details in the dialog box.  
   - Enter a name, select quantity (or provide a custom value), and choose a unit.  
   - Click **Add** to save the item or **Cancel** to discard changes.  

2. **View Items**:  
   - Newly added items appear in a list below the **Add Item** button, showing their details.  

3. **Edit Items**:  
   - Click the **Edit** button next to an item to enable inline editing.  
   - Update the name, quantity, or unit as needed.  
   - Click **Save** to save changes.  

4. **Delete Items**:  
   - Click the **Delete** button to remove an item from the list.  

---

## 🎯 Future Enhancements  

- **Sorting and Filtering**: Organize items by name, quantity, or unit.  
- **Clear All**: Add an option to delete all items in one go.  
- **Cloud Sync**: Save and access your shopping list across devices.  
- **Categories**: Group items into categories such as groceries, electronics, etc.  

---

## 📦 Getting Started  

1. Clone the repository:  
   ```bash
   git clone https://github.com/your-username/shopping-list.git
   ```  
2. Open the project in **Android Studio**.  
3. Build and run the app on an Android device or emulator.  

---

## 🤝 Contributing  

We welcome contributions! Here’s how to contribute:  
1. Fork this repository.  
2. Create a feature branch:  
   ```bash
   git checkout -b feature-name
   ```  
3. Commit your changes:  
   ```bash
   git commit -m "Add feature-name"
   ```  
4. Push the branch:  
   ```bash
   git push origin feature-name
   ```  
5. Open a pull request.  
