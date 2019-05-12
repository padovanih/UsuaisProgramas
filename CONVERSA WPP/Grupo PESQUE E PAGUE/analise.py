import unidecode
import matplotlib.pyplot as plt
from collections import OrderedDict
from operator import itemgetter
import numpy as np









p = open("cvsa.txt", "r", encoding="utf8")
textao = p.read()
p.close()


textao = unidecode.unidecode(textao)
textao = textao.lower()
#textao = textao.replace("\n","")

p = open("cvsa2.txt","w")
p.write(textao)
p.close()



















def addBefore(line, vet, pos):
	vet[pos] = vet[pos].replace("\n"," ")
	#vet[pos] = "".join(ch for ch in vet[pos] if (ch.isalnum() or ch==' '))
	vet[pos] = vet[pos] + " " + line

def addVet(line,vet):
	#vet.append( "".join(ch for ch in line if (ch.isalnum() or ch==' ')) )
	vet.append(line)

p = open("cvsa2.txt","r")
vet = []
k = 0


for line in p:
	
	line = line.replace("vcs","voces")
	line = line.replace("vc","voce")
	line = line.replace("simm","sim")
	
	line = line.replace("ameiiii","amei")
	line = line.replace("ameiii","amei")
	line = line.replace("ameii","amei")
	line = line.replace("mt","muito")
	line = line.replace("tambem","tbm")
	
	
	
	if(len(line)>=6):
		line = line.replace("<arquivo de midia oculto>"," ")
		line = line.replace("esta mensagem foi apagada"," ")
		if (line[2] != '/' or line[5] != '/'):
			addBefore(line,vet,k-1)
		else:
			addVet(line,vet)
			k += 1
		continue
	
	if (len(line) >= 3):
		if (line[2] != '/'):
			addBefore(line,vet,k-1)
		else:
			addVet(line,vet)
			k += 1
		continue
	
	addBefore(line,vet,k-1)
	#print(vet)
	

p.close()




p = open("cvsa3.txt","w")

for i in vet:
	p.write(i)
	
p.close()





























def chr_remove(old, to_remove):
	new_string = old
	if(new_string == ''):
		return ''
	for x in to_remove:
		try:
			new_string = new_string.replace(x, '')
		except :
			pass
	return new_string





dicPalavras = {} # guarda as palavras de todos mundo
dicPessoas  = {} # Guarda a quantidade de vezes que cada um falou

for linha in vet:
	
	words = linha.split()
	#print(str(words) + " -> " +str(len(words)))
	
	if(words[3] == 'padovani:'):
		try:
			dicPessoas[ words[3][:-1] ] += 1
		except  :
			dicPessoas[ words[3][:-1] ] = 1
		
		for k in range(4, len(words)):
			if(words[k] == '' ):
				continue
			
			words[k] = chr_remove(words[k], "'!@#$%¨&*()-+=_^~][´`;:.,><?/|" + '"')
			
			try:
				dicPalavras[ words[k] ]     += 1
			except  :
				dicPalavras[ words[k] ]     = 1
	
	elif len(words)>=6:
		if (words[3]+' '+words[4]+' '+words[5] == 'rubens borrasca neto:'):
			
			try:
				dicPessoas[ words[3]+ ' ' + words[4]+ ' ' + words[5][:-1] ] += 1
			except  :
				dicPessoas[ words[3]+ ' ' + words[4]+ ' ' + words[5][:-1]  ] = 1
			
			for k in range(6, len(words)):
				words[k] = chr_remove(words[k], "'!@#$%¨&*()-+=_^~][´`;:.,><?/|" + '"')
				if (words[k] == ''):
					continue
				
				try:
					dicPalavras[ words[k] ]     += 1
				except  :
					dicPalavras[ words[k] ]     = 1
		
		elif ( words[3]+' '+words[4]+' '+words[5] == 'pedro henrique smiderle:'):
			
			try:
				dicPessoas[ words[3]+ ' ' + words[4]+ ' ' + words[5][:-1] ] += 1
			except  :
				dicPessoas[ words[3]+ ' ' + words[4]+ ' ' + words[5][:-1]  ] = 1
			
			for k in range(6, len(words)):
				words[k] = chr_remove(words[k], "'!@#$%¨&*()-+=_^~][´`;:.,><?/|" + '"')
				if (words[k] == ''):
					continue
				
				try:
					dicPalavras[ words[k] ]     += 1
				except  :
					dicPalavras[ words[k] ]     = 1
		else:
			try:
				dicPessoas[ words[3]+ ' ' + words[4][:-1] ] += 1
			except  :
				dicPessoas[ words[3]+ ' ' + words[4][:-1] ] = 1
			
			for k in range(6, len(words)):
				words[k] = chr_remove(words[k], "'!@#$%¨&*()-+=_^~][´`;:.,><?/|" + '"')
				if (words[k] == ''):
					continue
				
				try:
					dicPalavras[ words[k] ]     += 1
				except  :
					dicPalavras[ words[k] ]     = 1
	
	
	else:
		try:
			dicPessoas[ words[3]+ ' ' + words[4][:-1] ] += 1
		except  :
			dicPessoas[ words[3]+ ' ' + words[4][:-1] ] = 1
		
		for k in range(6, len(words)):
			words[k] = chr_remove(words[k], "'!@#$%¨&*()-+=_^~][´`;:.,><?/|" + '"')
			if (words[k] == ''):
				continue
			
			try:
				dicPalavras[ words[k] ]     += 1
			except  :
				dicPalavras[ words[k] ]     = 1
				
































dicPessoas = OrderedDict(sorted(dicPessoas.items(), key=itemgetter(1), reverse=True))
dicPalavras = OrderedDict(sorted(dicPalavras.items(), key=itemgetter(1), reverse=True))

'''
for k,v in dicPalavras.items():
	print( str(k) + " : " +str(v) )
'''

p = open("word_cloud.txt", "w")
for k,v in dicPalavras.items():
	
	for i in range(v):
		p.write("{} ".format(k))
	
p.close()


retirar = ["pro","ta","na","uns","umas","um","uma","pela","as","os","mas","que","e","o","a","ante","apos","ate","com","conforme","contra","consoante","de","desde","durante","em","excepto","entre","mediante","para","perante","por","salvo","sem","segundo","sob","sobre", "tras"]

p = open("word_cloud_selecionado.txt", "w")
for k,v in dicPalavras.items():
	
	if k in retirar:
		continue
	for i in range(v):
		p.write("{} ".format(k))
	
p.close()
































 # PLOT
plt.rcdefaults()
fig, ax = plt.subplots()

y_pos = np.arange(len(dicPessoas.values()))
y_pos = [ 2*i for i in y_pos ]
performance = [i for i in dicPessoas.values()]
people      = [i for i in dicPessoas.keys()]

y_pos = y_pos[0:12]
performance = performance[0:12]
people = people[0:12]

ax.barh(y_pos, performance,align='center', color='green', ecolor='black')
ax.set_yticks(y_pos)
ax.set_yticklabels(people)
ax.invert_yaxis()  # labels read top-to-bottom
ax.set_xlabel('Número de mensagens enviadas')
ax.set_ylabel('Telefone')
# ax.set_title('Lindos do Rotation')

plt.show()






