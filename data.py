#Seda Nur EkİCİ 200201050    - Begüm Erva ŞAHİN 200201020
import pandas as pd
import nltk
from nltk.corpus import stopwords
from nltk import pos_tag
from nltk.probability import FreqDist
#from newspaper import Article, fulltext
import requests, string

data = pd.read_csv("C:/Users/ervas/OneDrive/Masaüstü/son/rows.csv",low_memory=False)

ydata=data.drop(["Date received","Sub-product","Sub-issue","Consumer complaint narrative","Company public response","Tags","Consumer consent provided?","Submitted via","Date sent to company","Company response to consumer","Timely response?","Consumer disputed?"],axis=1)
#ydata.shape #satır ve sutun gösterir
#ydata.columns=ydata.columns.str.replace(" ","_")
#ydata.columns
ydata.dropna(how="all",inplace=True)
ydata.dropna(how="any",inplace=True)


#ydata.dtypes#tiplerini gösterir
#ydata.isnull().sum()  #boş olan yerleri gösterir


ydata["Product"]=ydata["Product"].apply(lambda x:x.replace(",","")).apply(lambda x:x.replace(".","")).\
    apply(lambda x:x.replace("/","")).apply(lambda x:x.replace("'","")).apply(lambda x:x.replace("&","")).apply(lambda x:x.replace(":","")).\
    apply(lambda x:x.replace("-",""))
ydata["Issue"]=ydata["Issue"].apply(lambda x:x.replace(",","")).apply(lambda x:x.replace(".","")).\
    apply(lambda x:x.replace("/","")).apply(lambda x:x.replace("'","")).apply(lambda x:x.replace("&","")).apply(lambda x:x.replace(":","")).\
    apply(lambda x:x.replace("-",""))
ydata["Company"]=ydata["Company"].apply(lambda x:x.replace(",","")).apply(lambda x:x.replace(".","")).\
    apply(lambda x:x.replace("/","")).apply(lambda x:x.replace("'","")).apply(lambda x:x.replace("&","")).apply(lambda x:x.replace(":","")).\
    apply(lambda x:x.replace("-",""))
ydata["State"]=ydata["State"].apply(lambda x:x.replace(",","")).apply(lambda x:x.replace(".","")).\
    apply(lambda x:x.replace("/","")).apply(lambda x:x.replace("'","")).apply(lambda x:x.replace("&","")).apply(lambda x:x.replace(":","")).\
    apply(lambda x:x.replace("-",""))


#ydata.head(20)


#ydata.isnull().sum()
#ydata.shape

ydata['Product']=ydata['Product'].str.lower()
ydata['Issue']=ydata['Issue'].str.lower()
ydata['Company']=ydata['Company'].str.lower()
ydata['State']=ydata['State'].str.lower()

#-------------------------------------------------------

nltk.download('stopwords')
" ".join(stopwords.words('english'))
stop_words=set(stopwords.words('english'))

def remove_stop(x):
    return " ".join([word for word in str(x).split() if word not in stop_words])
ydata['Product']=ydata['Product'].apply(lambda x : remove_stop(x))
ydata['Issue']=ydata['Issue'].apply(lambda x : remove_stop(x))
ydata['Company']=ydata['Company'].apply(lambda x : remove_stop(x))

ydata.to_csv("veriler.csv")