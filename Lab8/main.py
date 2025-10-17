# Лабораторна робота №8
import math
import struct

# --- Головний блок програми ---
try:

    x = float(input("Введіть значення x (в градусах): "))

    # Обчислюємо вираз y = sin(x) / ctg(8x)
    radians_x = math.radians(x)
    denominator = 1.0 / math.tan(math.radians(8 * x))

    # Перевіряємо ділення на нуль
    if abs(denominator) < 1e-12:
        raise ValueError(f"Ділення на нуль: ctg(8x) дорівнює нулю для x = {x}.")

    result = math.sin(radians_x) / denominator
    print(f"Результат обчислення: {result}")

    # Записуємо результат
    with open("result.txt", "w") as f:
        f.write(str(result))
    print("Результат записано у result.txt")

    # Читаємо результат
    with open("result.txt", "r") as f:
        read_result = float(f.read())
    print(f"Результат, зчитаний з result.txt: {read_result}")


    # Записуємо результат
    with open("result.bin", "wb") as f:
        f.write(struct.pack('d', result))
    print("Результат записано у result.bin")

    # Читаємо результат
    with open("result.bin", "rb") as f:
        packed_result = f.read()
        read_result = struct.unpack('d', packed_result)[0]
    print(f"Результат, зчитаний з result.bin: {read_result}")

except (ValueError, IOError) as e:
    # Ловимо всі можливі помилки (неправильне введення, обчислення, робота з файлом)
    print(f"Сталася помилка: {e}")