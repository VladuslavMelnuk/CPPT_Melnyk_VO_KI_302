# main.py
from phone_package.mobile_phone import MobilePhone

def main():
    """
    Головна функція для демонстрації роботи класів.
    """
    print("--- Створюємо об'єкт MobilePhone ---")
    my_phone = MobilePhone(model="iPhone 15", has_touchscreen=True)

    print("\n--- Демонструємо роботу методів ---")
    
    # Викликаємо успадкований метод
    my_phone.turn_on()
    
    # Викликаємо новий метод
    my_phone.connect_to_wifi("MyHomeNetwork")
    
    # Викликаємо перевизначений метод
    info = my_phone.get_info()
    print(f"Інформація про пристрій: {info}")
    
    # Викликаємо успадкований метод
    my_phone.turn_off()
    info_after_off = my_phone.get_info()
    print(f"Інформація про пристрій: {info_after_off}")


# Стандартна конструкція для запуску головної функції
if __name__ == "__main__":
    main()