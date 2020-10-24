class Calculator:
    
    def max3(self, b, c, d):
        max = b
        if c > max:
            max = c
        if d > max:
            max = d
        return max

print("a의 값 : ")
a = input()
print("b의 값 : ")
b = input()
print("c의 값 : ")
c = input()
print(Calculator().max3(a,b,c))