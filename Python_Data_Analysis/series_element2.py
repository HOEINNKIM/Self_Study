#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jul 31 13:37:28 2019

@author: hoeinnkim
"""

import pandas as pd

exam_data = {'이름' : ['서준','우현','인아'],
             '수학' : [90,80,70],
             '영어' : [85,95,75],
             '음악' : [70,50,60],
             '체육' : [75,86,84]}

df = pd.DataFrame(exam_data)

df.set_index('이름', inplace=True)
print(df)

a = df.loc['서준','음악']
print(a)
b = df.iloc[0,2]
print(b)
c = df.loc['서준',['수학','음악']]
print(c)
d = df.iloc[0,[2,3]]
print(d)
e = df.loc['서준','음악':'체육']
print(e)

df['국어'] = 80
print(df)
