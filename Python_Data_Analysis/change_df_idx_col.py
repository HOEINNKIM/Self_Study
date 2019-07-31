#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jul 31 13:19:42 2019

@author: hoeinnkim
"""

import pandas as pd

df = pd.DataFrame([[15,'남','덕중'],[17,'여','수리']],
                  index=['호우','헤이'],
                  columns=['나이','성별','과목'])

print(df)