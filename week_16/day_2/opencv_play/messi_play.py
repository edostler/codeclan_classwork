import cv2
import numpy

img = cv2.imread("messi.jpg")

# print(img)

# Finding and moving the ball:
# Ball Point 1 is about 360 by 280
# Ball Point 2 is about 410 by 330
# [y1:y2, x1x2]

ball = img[280:330, 360:410]
img[180:230, 260:310] = ball

cv2.imwrite("messi_modified.jpg", img)
