#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Jul 30 16:31:40 2019

@author: hoeinnkim
"""

import pandas as pd

list_data = ['2019-01-02', 3.14, 'ABC', 100, True]
sr = pd.Series(list_data)
print(sr)

idx = sr.index
val = sr.values
print(idx)
print('\n')
print(val)