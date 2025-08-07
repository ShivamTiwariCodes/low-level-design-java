Clean and simple **Cheat Sheet** in **text format**, properly categorized for you:

---

# 🎯 Design Patterns Cheat Sheet

---

## 1. **Creational Patterns** (🛠 *How objects are created*)

| Pattern | When to Use | Quick Idea |
|:--------|:------------|:-----------|
| **Singleton** | Only one instance must exist | Global instance (e.g., Database Connection) |
| **Factory Method** | Let subclasses decide which object to create | Interface-driven object creation |
| **Abstract Factory** | Create families of related objects | Theme factory: Dark/Light UI components |
| **Builder** | Create complex objects step by step | Building a `Pizza` with optional toppings |
| **Prototype** | Clone existing objects | Copy existing object rather than creating new |

---

## 2. **Structural Patterns** (🏗 *How objects are structured/composed*)

| Pattern | When to Use | Quick Idea |
|:--------|:------------|:-----------|
| **Adapter** | Interface mismatch between systems | Old payment API to new system |
| **Bridge** | Separate abstraction and implementation | Remote control + different devices |
| **Composite** | Treat individual and group uniformly | Tree-like structure (files, folders) |
| **Decorator** | Add responsibilities dynamically | Add features to a coffee order |
| **Facade** | Simplify complex subsystem | Single entry point for complicated APIs |
| **Flyweight** | Share common objects to save memory | Text editors sharing character formatting |
| **Proxy** | Control access to another object | Access control for heavy services (e.g., lazy-loading images) |

| **NOTE** | Facade composite bridge made by flyweight proxy adaptor and decorator |

---

## 3. **Behavioral Patterns** (🔁 *How objects communicate or behave*)

| Pattern | When to Use | Quick Idea |
|:--------|:------------|:-----------|
| **Chain of Responsibility** | Multiple handlers for a request | Approvals (Manager → Director → CEO) |
| **Command** | Encapsulate a request as an object | Undo/Redo system |
| **Interpreter** | Evaluate grammar or expression | Simple calculators, SQL parsing |
| **Iterator** | Traverse elements without exposing structure | Loop over a collection |
| **Mediator** | Central authority for communication | Chat room for users |
| **Memento** | Restore previous state | Save game state |
| **Observer** | Notify multiple objects of state change | Event listeners, notification systems |
| **State** | Object behavior changes based on state | Traffic light changing behavior |
| **Strategy** | Change behavior at runtime | Different sorting algorithms selected dynamically |
| **Template Method** | Define skeleton, let subclasses fill steps | Cooking recipe steps (boil, fry, serve) |
| **Visitor** | Add operations to classes without changing them | Tax calculation on different types of items |

---

# 🧠 Super Quick Guide:
| What’s the issue? | Look here → |
|:------------------|:-----------|
| **Object Creation** issues | ➡️ Creational Patterns |
| **Object Structure/Combination** issues | ➡️ Structural Patterns |
| **Object Communication/Behavior** issues | ➡️ Behavioral Patterns |

---
