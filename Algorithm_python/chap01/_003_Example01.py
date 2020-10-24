class Calculator:
    def max4(self, a, b, c, d):
        max = a
        if(b > max):
            max = b
        if(c > max):
            max = c
        if(d > max):
            max = d
        print(max)

    def min3(self, a, b, c):
        min = a
        if(b > min):
            min = b
        if(c > min):
            min = c
        print(min)

    def min4(self, a, b, c, d):
        min = a
        if(b < min):
            min = b
        if(c < min):
            min = c
        if(d < min):
            min = d
        print(min)

Calculator().max4(1,2,3,4)
Calculator().min3(1,2,3)
Calculator().min4(1,2,3,4)
