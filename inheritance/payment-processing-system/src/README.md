# Inheritance Exercise

## Goal
Practice inheritance, abstract classes, polymosphism and template methods in Java.

## Description
PaymenMethod is the parent abstract class.
PaymentMethod has a template method called processPayment, which cannot be overriden by any subclass (it is declared as final).
CreditCardPayment, DebitCardPayment and PayPalPayment extend PaymentMethod and override the methods calculateFee, hasSuffcientBalance, deductBalace and validatePayment, which are all called inside the template method processPayment.

## Concepts
- inheritance
- abstract class
- method overriding
- polymorphism
- template method
