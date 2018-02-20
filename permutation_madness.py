"""  Challenge #351 Permutation madness
A group of programs has gotten together in a line and have started dancing
They appear to have 3 dance moves.
    Try Spin that's a good trick, the right end swaps up most left keeing their order
    Exchange Two programs appear to swap depending on the numbers given
    Partner Two programs that know eachother swaps
    
input from input.txt in the same directory
 """
import os,sys,time

def command(couple, com):
    #spin
    if com[0] == 's':
        for s in range(int(com[1:])):
            couple.insert(0, couple.pop())
    #exchange
    elif com[0] == 'x':
        index1, index2 = (int(j) for j in com[1:].split('/'))
        couple[index1], couple[index2] = couple[index2], couple[index1]
    #partner
    else:
        index1, index2 = (int(j) for j in com[1:].split('/'))
        f_i1 = 0
        f_i2 = 0
        for cou in couple:
            if cou[1] == index1:
                f_il = couple.index(cou)
            elif cou[1] == index2:
                f_i2 = couple.index(cou)
        couple[f_il], couple[f_i2] = couple[f_i2], couple[f_il]
        
if __name__ == '__main__':
    start = time.time()
    f = open('input.txt','r')   
    uInput = f.readline()
    couple = []
    index = 0
    # create couple between char and index for partner command
    for ch in uInput:
        if ch != '\n':
            couple.append((ch, index))
            index += 1
    # read commands
    for line in f:
        commands_str = line.split(',')
        for com in commands_str:
            command(couple, com)
    # print result
    end = time.time()
    result = 'result is : '
    for cou in couple:
        result += cou[0]
    print('result : ' + result + '\n in %.2f s' %(end - start)) 

