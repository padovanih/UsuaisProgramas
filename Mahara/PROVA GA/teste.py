import pyautogui as pag
import time as t



t.sleep(7)

def cria(vetor):
	for i in vetor:
		pag.typewrite(i)
		pag.press('enter')
		t.sleep(0.05)



# CRIA OS FABRICANTES
cria(["1","FAB_1","BRA","111"])
cria(["1","FAB_2","ARG","222"])
cria(["1","FAB_3","GER","333"])
cria(["1","FAB_4","POL","444"])

# MOSTRA NA TELA 
cria(["11"])

# CRIA OS AERONAVES
cria(["2","AERO1","MODEL1","MATRICULA1","111"])
cria(["2","AERO2","MODEL2","MATRICULA2","222"])
cria(["2","AERO3","MODEL3","MATRICULA3","333"])
cria(["2","AERO4","MODEL4","MATRICULA4","444"])
cria(["2","AERO5","MODEL5","MATRICULA5","111"])
cria(["2","AERO6","MODEL6","MATRICULA6","222"])
cria(["2","AERO7","MODEL7","MATRICULA7","111"])

# MOSTRA NA TELA 
cria(["12"])





