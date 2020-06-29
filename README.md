### 媒体服务器主要功能
- 与信令服务器建立ws连接
- 向信令服务器发送sdp和candidate信息并接收信令服务器转发的客户端的sdp和candidate信息
- 与所有客户端进行ice打洞流程
- 接收信令服务器转发的用户状态信息（发言者和非发言者）
- 接收发言者发送的音频数据。
- 解码、混流、编码发言者发送的音频数据。
- 转发音频数据
  - 客户端的状态如果是发言者，则直接发送其他发言者的原始音频数据。
  - 客户端的状态如果是非发言者，则发送混流过的音频数据。
