# mobile_phone.py
from .telephone import Telephone

class MobilePhone(Telephone):
    """
    Клас-нащадок, що представляє мобільний телефон.
    Успадковує клас Telephone і додає нові можливості.
    """
    
    # Конструктор класу MobilePhone
    def __init__(self, model, has_touchscreen):
        # Викликаємо конструктор батьківського класу Telephone
        super().__init__(model)
        self._has_touchscreen = has_touchscreen

    def connect_to_wifi(self, network_name):
        """Новий метод для підключення до Wi-Fi."""
        if self._is_on:
            print(f"{self._model}: Підключено до Wi-Fi '{network_name}'.")
        else:
            print(f"{self._model}: Неможливо підключитись до Wi-Fi, телефон вимкнено.")

    # Перевизначаємо метод батьківського класу, щоб додати нову інформацію
    def get_info(self):
        """Повертає розширену інформацію про мобільний телефон."""
        # Викликаємо оригінальний метод get_info() з класу Telephone
        base_info = super().get_info()
        touch_info = "Так" if self._has_touchscreen else "Ні"
        return f"{base_info}, Сенсорний екран: {touch_info}"