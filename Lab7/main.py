
try:
    size = int(input("Введіть розмір квадратної матриці: "))
    if size <= 0:
        print("Помилка: Розмір має бути додатнім числом.")
        exit() 

    filler = input("Введіть символ-заповнювач: ")
    if len(filler) != 1:
        print("\nПомилка: Потрібно ввести рівно один символ.")
        exit() 

    print("\nРезультат:")

    num_cols = (size + 1) // 2

    for _ in range(size):
        print('  '.join([filler] * num_cols))

except ValueError:
    print("Помилка: Розмір матриці має бути цілим числом.")
