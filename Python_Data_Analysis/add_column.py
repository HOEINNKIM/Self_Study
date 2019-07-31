#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jul 31 13:53:15 2019

@author: hoeinnkim
"""

import pandas as pd

exam_data = {'이름' : ['이이','아아','오오'],
             '수학' : [90,80,70],
             '영어' : [89,79,69],
             '음악' : [88,78,68],
             '체육' : [86,85,84]}
df = pd.DataFrame(exam_data)
print(df)
print('\n')

df['국어'] = 80
print(df)