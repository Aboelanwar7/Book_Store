# Quantum Bookstore System

A comprehensive Java-based online bookstore system that supports multiple book types with extensible architecture.

## Features

- **Multiple Book Types**: Paper books, eBooks, and showcase/demo books
- **Inventory Management**: Add books, remove outdated books, track stock
- **Purchase System**: Buy books with email and shipping address
- **Extensible Design**: Easy to add new book types without modifying existing code
- **Stock Management**: Automatic stock reduction for paper books
- **External Services**: Integration with shipping and mail services

## Book Types

### Paper Books
- Have physical stock quantity
- Reduce stock when purchased
- Shipped via ShippingService
- Can go out of stock

### eBooks
- Digital books with file types (PDF, EPUB, etc.)
- Unlimited availability
- Delivered via MailService
- No stock limitations

### Showcase Books
- Demo books not for sale
- Display purposes only
- Cannot be purchased

## Project Structure

```
org.example.bookStore/
├── model/
│   ├── Book.java                    # Abstract base class
│   ├── PaperBook.java              # Paper book implementation
│   ├── EBook.java                  # Electronic book implementation
│   ├── ShowcaseBook.java           # Demo book implementation
│   └── PurchaseResult.java         # Purchase result data
├── service/
│   ├── BookStoreSystem.java        # Main bookstore service
│   ├── ShippingService.java        # Handles shipping
│   └── MailService.java            # Handles email delivery
└── test/
    └── QuantumBookstoreFullTest.java # Test suite
```

## Getting Started

### Prerequisites
- Java 8 or higher
- Lombok library (for annotations)

### Installation
1. Clone the repository
2. Import the project into your IDE
3. Ensure Lombok is configured in your IDE
4. Run the main class or test suite

## Key Classes

### BookStoreSystem
Main service class that handles:
- Adding books to inventory
- Removing outdated books
- Processing purchases
- Managing inventory

### Book (Abstract)
Base class for all book types with common properties:
- ISBN, title, author, publish year, price
- Abstract methods for purchasing and age checking

### PurchaseResult
Data class containing:
- Total amount paid
- Purchase success message

## Error Handling

The system handles various error scenarios:
- **Insufficient Stock**: When trying to buy more paper books than available
- **Book Not Found**: When trying to buy a book that doesn't exist
- **Showcase Purchase**: When trying to buy a showcase book
- **Outdated Books**: Automatic removal based on age criteria

## Dependencies

- **Lombok**: Used for reducing boilerplate code with annotations
  - `@AllArgsConstructor`
  - `@Getter`
