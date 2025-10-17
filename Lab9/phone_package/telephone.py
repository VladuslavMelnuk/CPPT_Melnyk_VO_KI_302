# telephone.py

class Telephone:
    """
    Базовий клас, що представляє загальний телефон.
    """
    
    # Конструктор класу. Викликається при створенні об'єкта.
    def __init__(self, model):
        self._model = model  # _model - захищене поле
        self._is_on = False

    def turn_on(self):
        """Вмикає телефон."""
        self._is_on = True
        print(f"{self._model}: Телефон увімкнено.")

    def turn_off(self):
        """Вимикає телефон."""
        self._is_on = False
        print(f"{self._model}: Телефон вимкнено.")

    def get_info(self):
        """Повертає інформацію про стан телефону."""
        status = "увімкнено" if self._is_on else "вимкнено"
        return f"Модель: {self._model}, Стан: {status}"