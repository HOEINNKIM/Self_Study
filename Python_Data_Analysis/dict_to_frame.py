#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jul 31 13:16:45 2019

@author: hoeinnkim
"""

import pandas as pd

dict_data = {'c0' : [1,2,3], 'c1': [4,5,6],'c2':[7,8,9],'c3':[10,11,12],'c4':[13,14,15]}
df = pd.DataFrame(dict_data)

print(type(df))
print('\n')

print(df)